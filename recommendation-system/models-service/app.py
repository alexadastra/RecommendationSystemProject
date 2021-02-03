from py_eureka_client.eureka_client import EurekaClient

from flask import Flask
from flask import jsonify

import requests as req
import find_recommended

app = Flask(__name__)

client = EurekaClient(eureka_server="http://localhost:8761", app_name="model-service", instance_port=8000)
client.start()

from flask_cors import CORS

cors = CORS(app, resources={r"/*": {"origins": "*"}})


@app.route('/model')
def hello_world():
    available_items = req.get("http://localhost:8083/available")

    recommended_items = find_recommended.find_recommended(available_items.json())
    return jsonify(recommended_items)


a = [{"id": 0, "img": "../static/store/img/product_img.jpg", "title": "Товар A", "description": "aaa", "price": 10}, \
     {"id": 1, "img": "../static/store/img/product_img.jpg", "title": "Товар B", "description": "bbb", "price": 20}, \
     {"id": 2, "img": "../static/store/img/product_img.jpg", "title": "Товар C", "description": "ccc", "price": 30}, \
     {"id": 3, "img": "../static/store/img/product_img.jpg", "title": "Товар D", "description": "ddd", "price": 40}, \
     {"id": 4, "img": "../static/store/img/product_img.jpg", "title": "Товар E", "description": "eee", "price": 50}, \
     {"id": 5, "img": "../static/store/img/product_img.jpg", "title": "Товар F", "description": "fff", "price": 70}]


@app.route('/jsons')
def get_products_row():
    return jsonify(a)


@app.route('/jsons/<product_id>')
def get_product_by_id(product_id):
    for item in a:
        if item["id"] == int(product_id):
            return jsonify(item)


if __name__ == '__main__':
    app.run(host="localhost", port=8000, debug=True)
