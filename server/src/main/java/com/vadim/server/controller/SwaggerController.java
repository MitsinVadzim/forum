package com.vadim.server.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerController {

    private final String uiConfiguration;
    private final String configuration;
    private final String json;

    @SneakyThrows
    public SwaggerController(final ResourceLoader resourceLoader,
                             final ObjectMapper objectMapper,
                             final Yaml yaml) {

        final JsonNode configurationUiJson = loadJson(
                objectMapper,
                resourceLoader,
                "classpath:/swagger/configuration-ui.json"
        );
        final JsonNode configurationJson = loadJson(
                objectMapper,
                resourceLoader,
                "classpath:/swagger/configuration.json"
        );
        final Map<?, ?> swaggerYaml = loadYaml(yaml, resourceLoader, "classpath:/swagger/openapi.yaml");

        this.uiConfiguration = objectMapper.writeValueAsString(configurationUiJson);
        this.configuration = objectMapper.writeValueAsString(configurationJson);
        this.json = objectMapper.writeValueAsString(swaggerYaml);
    }

    @GetMapping("/")
    public String swaggerUiRedirect() {
        return "redirect:swagger-ui.html";
    }

    @ResponseBody
    @GetMapping("/swagger-resources/configuration/ui")
    public String swaggerUiConfiguration() {
        return uiConfiguration;
    }

    @ResponseBody
    @GetMapping("/swagger-resources")
    public String swaggerConfiguration() {
        return configuration;
    }

    @ResponseBody
    @GetMapping("/swagger.json")
    public String swaggerJson() {
        return json;
    }

    private Map<?, ?> loadYaml(
            final Yaml yaml,
            final ResourceLoader resourceLoader,
            final String location
    ) throws IOException {
        return yaml.load(resourceLoader.getResource(location).getInputStream());
    }

    private JsonNode loadJson(
            final ObjectMapper objectMapper,
            final ResourceLoader resourceLoader,
            final String location
    ) throws IOException {
        return objectMapper.readTree(resourceLoader.getResource(location).getInputStream());
    }
}
