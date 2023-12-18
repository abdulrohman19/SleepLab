import tensorflow as tf
from flask import Flask, request, jsonify, make_response
import numpy as np

app = Flask(__name__)

model = tf.keras.models.load_model('sleeplab.h5')

@app.route('/')
def index():
    return 'API running!'

@app.route('/predict', methods=['POST'])
def predict():
    try:
        sleep_duration = request.json['sleep_duration']

        pyshical_activity_level = request.json['pyshical_activity_level']

        bmi_category = request.json['bmi_category']

        input_data = np.array([float(sleep_duration), float(pyshical_activity_level), float(bmi_category)]).reshape(1,-1)

        prediction = model.predict(input_data)

        rounded_sleep_disorder = np.round(prediction)

        predicted_class = int(rounded_sleep_disorder.argmax(axis=-1))

        print(prediction)
        print(rounded_sleep_disorder)
        print(predicted_class)

        result = {'message': 'success','prediction': predicted_class, 'rounded_sleep_disorder': rounded_sleep_disorder.tolist(), 'prediction_probability': prediction.tolist()}

        response = make_response(
            jsonify(
                result
            ),
            200,
        )
        response.headers['Content-Type'] = 'application/json'

        return response

    except Exception as e:
        response = make_response(
            jsonify(
                {'error': str(e)}
            ),
            500,
        )
        response.headers['Content-Type'] = 'application/json'
        return response

if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0")