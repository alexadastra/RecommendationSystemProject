from flask_eureka import Eureka
from flask_eureka.eureka import eureka_bp


def initialize_eureka(app):
    eureka = Eureka(app)
    eureka.register_service(name="my-flask-service")

    app.register_blueprint(eureka_bp)
