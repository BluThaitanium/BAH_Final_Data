package com.bah.msd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;

@SpringBootApplication
public class MsdProjectDataServiceApplication {

	public static void main(String[] args) {
		System.out.println("my rock n roll spring boot app is starting.....all cool..");
		SpringApplication.run(MsdProjectDataServiceApplication.class, args);
	}

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
	    return new Configuration("data-api", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
	        new Configuration.ReporterConfiguration())
	        .getTracer();
	}

}
