package com.econotravel.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(

                new Experience("Paseo por el Montseny", 300, 5,"Actividad disponible para todas las edades", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny. Una escapada veraniega perfecta para parejas, familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. El recorrido que os proponemos comienza con una larga subida con algunos descansos, combinando asfalto y pistas anchas, culminando en un mirador con magníficas vistas del Vallés y el mar. Desde aquí continuaremos la bajada combinando senderos, pistas y algún tramo de carretera y terreno mixto para visitar la zona de Santa Fe, donde descubriremos la Ermita y el Bosque de las Secuoyas. Para finalizar, acudiremos al restaurante María Rosa de Palautordera, donde disfrutaremos de una excelente comida casera con butifarra blanca y negra y munxetes del Montseny.","Montaña, bicicleta, excursión larga."),

                new Experience("Visita a la sagrada familia", 30, 4, "Actividad disponible para todas las edades y accesible para silla de ruedas","Visitar la Sagrada Familia, el monumento por excelencia de Barcelona, es una experiencia imprescindible en la capital catalana. ¡Conoceréis la obra maestra de Antonio Gaudí!.Dentro de este majestuoso templo, descubriréis el diseño original de Gaudí representado sobre una maqueta y conoceréis cómo concibió su obra final, hoy en día aún sin terminar. Durante la visita podréis apreciar el simbolismo cristiano detrás de cada elemento de la basílica.","         Gaudí, Basílica,Arquitectura y Turistico"),


                new Experience("Arte en la montaña sagrada", 125, 2,"Actividad disponible para todas las edades","Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo encontraréis pinturas del Renacimiento y del Barroco que conviven con autores de los siglos XIX y XX, objetos del Próximo Oriente y orfebrería. Además de disfrutar de un paseo guiado por la montaña y el Museo, esta actividad incluye tentempié variado acompañado de vino espumoso, cava brut o refresco.","Montaña, a pie,excursión corta")

                new Experience( "Descubre la Barcelona Modernista de noche", 200,4 ,"Actividad disponible para todas las edades. Accesibilidad garantizada para sillas de ruedas","Desplazarse a pie es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, ubicado en el centro de la ciudad. En esta excursión de cuatro horas, descubriremos los principales emblemas del modernismo y visitaremos los templos y edificios más célebres del arquitecto Gaudí.El tour incluye visita guiada al interior de la Casa Batlló y la Sagrada Familia, así como parada para cenar en el restaurante típico catalán Can Masiá, donde disfrutaremos de las mejores carnes de la región acompañadas de vinos de las tierras del Baix Empordá. El restaurante también ofrece opciones vegetarianas y veganas así como menú para niños. Cava aparte.","Ciudad, a pie, excursión larga.")


        ));


    }
}