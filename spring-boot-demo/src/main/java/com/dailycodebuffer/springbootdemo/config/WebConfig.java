package com.dailycodebuffer.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // oara q sepa q esta es una es una clase de configuración de Spring.
public class WebConfig implements WebMvcConfigurer {
    // Al implementar la interfaz WebMvcConfigurer, la clase WebConfig puede
    // sobrescribir métodos que permiten personalizar o configurar el comportamiento
    // del framework Spring MVC.
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Habilita la negociación de contenido basada en un parámetro de solicitud
        configurer.favorParameter(true)
                // Establece "mediaType" como el nombre del parámetro que se utilizará en la URL
                .parameterName("mediaType")
                // Define JSON como el tipo de contenido por defecto si no se pasa ningún
                // parámetro
                .defaultContentType(MediaType.APPLICATION_JSON)
                // Si el parámetro es "mediaType=xml", se devuelve una respuesta en formato XML
                .mediaType("xml", MediaType.APPLICATION_XML)
                // Si el parámetro es "mediaType=json", se devuelve una respuesta en formato
                // JSON
                .mediaType("json", MediaType.APPLICATION_JSON);

    }
}
