package com.econotravel.api;

import com.econotravel.api.repositories.Experience;
import com.econotravel.api.repositories.ExperienceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Bftp2EconotravelServerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ExperienceRepository experienceRepository;

    @BeforeEach
    void setUp() {
        experienceRepository.deleteAll();
    }

    @Test
    void returnsTheExistingExperiences() throws Exception {

        addSampleExperiences();

        mockMvc.perform(get("/api/experiences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(4)))
                .andExpect(jsonPath("$[0].name", equalTo("Paseo en bicicleta por el Montseny")))
                .andExpect(jsonPath("$[0].price", equalTo(300)))
                .andExpect(jsonPath("$[0].duration", equalTo(5)))
                .andExpect(jsonPath("$[0].accessibility", equalTo("Actividad disponible para todas las edades.")))
                .andExpect(jsonPath("$[0].description", equalTo("Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, cava brut o refresco.")))
                .andExpect(jsonPath("$[0].labels", equalTo("Montaña, bicicleta,excursión larga.")))

                .andExpect(jsonPath("$[1].name", equalTo("Descubre la costa en barco de vela")))
                .andExpect(jsonPath("$[1].price", equalTo(250)))
                .andExpect(jsonPath("$[1].duration", equalTo(4)))
                .andExpect(jsonPath("$[1].accessibility", equalTo("Actividad disponible para todas las edades. Pasarela para silla de ruedas disponible bajo reserva."
                )))
                .andExpect(jsonPath("$[1].description", equalTo("Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas. Comenzaremos la excursión en el Puerto de Barcelona, desde donde partiremos hacia el norte para visitar playas como la Mar Bella, la Playa de la Mora y la Playa de los Pescadores. A bordo de la embarcación podremos disfrutar de una selección de quesos y embutidos catalanes acompañada de cava brut y zumos de frutas. Asimismo, pararemos cerca de la Playa de Montgat para realizar una actividad de buceo de superficie que nos permitirá apreciar la diversidad de la fauna marítima local y su ecosistema. Finalizaremos la excursión en el mismo puerto del que partimos.")))
                .andExpect(jsonPath("$[1].labels", equalTo("Playa, barco, excursión larga.")))

                .andExpect(jsonPath("$[2].name", equalTo(" Descubre la Barcelona Modernista de noche")))
                .andExpect(jsonPath("$[2].price", equalTo(200)))
                .andExpect(jsonPath("$[2].duration", equalTo(4)))
                .andExpect(jsonPath("$[2].accessibility", equalTo("Actividad disponible para todas las edades. Accesibilidad garantizada para sillas de ruedas")))
                .andExpect(jsonPath("$[2].description", equalTo("Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, ubicado en el centro de la ciudad. En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y edificios más célebres del arquitecto Gaudí.El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú para niños. Cava aparte.")))
                .andExpect(jsonPath("$[2].labels", equalTo("Ciudad, a pie, excursión larga.")))

                .andExpect(jsonPath("$[3].name", equalTo("Del huerto a la mesa ")))
                .andExpect(jsonPath("$[3].price", equalTo(145)))
                .andExpect(jsonPath("$[3].duration", equalTo(3)))
                .andExpect(jsonPath("$[3].accessibility", equalTo("Actividad disponible para todas las edades")))
                .andExpect(jsonPath("$[3].description", equalTo("Comparte con los más pequeños las maravillas de la naturaleza. En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig. Durante una hora y media, aprenderéis a cuidar de vuestro propio huerto, plantaréis y abonaréis vuestras propias plantas, y también recogeréis parte de los ingredientes que los expertos chefs de Can Gilabert utilizarán para preparar la posterior cena, donde disfrutaréis de la experiencia de consumir productos recién recogidos de la tierra con vuestras propias manos. Actividad ideal para familiarizar a los más pequeños de la familia con el estilo de vida rural y la agricultura sostenible. Asimismo, obtendréis como obsequio una botella de aceite virgen extra cultivado y preparado en Can Gilabert, obra de la familia Gilabert, que lleva más de 80 años cultivando olivos.")))
                .andExpect(jsonPath("$[3].labels", equalTo("Montaña, a pie,excursión corta")))

                .andExpect(jsonPath("$[4].name", equalTo("Arte en la montaña sagrada ")))
                .andExpect(jsonPath("$[4].price", equalTo(125)))
                .andExpect(jsonPath("$[4].duration", equalTo(2)))
                .andExpect(jsonPath("$[4].accessibility", equalTo("Actividad disponible para todas las edades")))
                .andExpect(jsonPath("$[4].description", equalTo("Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, cava brut o refresco.")))
                .andExpect(jsonPath("$[4].labels", equalTo("Montaña, a pie,excursión corta")))

                .andDo(print());
    }


    private void addSampleExperiences() {
        List<Experience> experiences = List.of(
                new Experience("Paseo en bicicleta por el Montseny", 300,"5h","Actividad disonible para todas las edades","\"Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña.","Montaña, bicicleta, excursión laga"),

                new Experience("Descubre la costa en barco de vela", 250,"4h","Actividad disponible para todas edades y accesible para silla de ruedas","Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona y visita desde el mar sus más impresionantes playas y calas.","playa,barco, excursión larga"),

                new Experience("Descubre la Barcelona Modernista de noche", 200,"4h","Actividad disponible para todas las edades y accesible para silla de ruedas","Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, ubicado en el centro de la ciudad.","ciudad a pie,excursión larga"),

                new Experience("Del huerto a la mesa", 145,"3h","Actividad disponible para todas las edades","Comparte con los más pequeños las maravillas de la naturaleza. En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig.","Montaña, a pie,excursión corta"),

                new Experience("Arte en la montaña sagrada", 125,"2h","Actividad disponible para todas las edades","Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña.","Montaña, a pie,excursión corta")
        );

        experienceRepository.saveAll(experiences);
    }

    @Test
    void createsNewExperiences() throws Exception {

        mockMvc.perform(post("/api/experiences")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Paseo en Bici por el Montseny\"}")
        ).andExpect(status().is(200));


        var experiences = experienceRepository.findAll();

        assertThat(experiences, contains(
                hasProperty("name", is("Paseo en Bici por el Montseny")),
                hasProperty("name", is("Descubre la costa en barco de vela")),
                hasProperty("name", is("Descubre la Barcelona Modernista de noche")),
                hasProperty("name", is("Del huerto a la mesa")),
                hasProperty("name", is("Arte en la montaña sagrada"))

        ));
    }

}
