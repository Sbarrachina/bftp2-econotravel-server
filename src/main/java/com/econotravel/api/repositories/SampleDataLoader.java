package com.econotravel.api.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(

                new Experience(1l,"Paseo en bicicleta por el Montseny", 300, 5,"Actividad disponible para todas las edades", "Disfruta de un hermoso paseo en bicicleta por el increíble Parque Natural del Montseny. Una escapada veraniega perfecta para parejas, familias y amigos que nos permitirá conocer nuevos y sorprendentes lugares. ","Montaña, bicicleta, excursión larga.","https://i.ibb.co/Vt6kGmz/BiciF.png"),

                new Experience( 2l,"Descubre la costa en barco de vela", 250, 4, "Actividad disponible para todas las edades y accesible para silla de ruedas","Disfruta de un hermoso paseo acuático en barco de vela por la increíble costa de Barcelona. Una escapada veraniega apta incluso para los días más calurosos del año. Descubre los encantadores alrededores de la ciudad de Barcelona  ", "Playa, barco, excursión larga.","https://i.ibb.co/MhV2nBM/BarcoF.png"),


                new Experience( 3l,"Descubre la Barcelona Modernista de noche", 200,4 ,"Actividad disponible para todas las edades. Accesibilidad garantizada para sillas de ruedas","Caminar es una de las mejores formas de descubrir las maravillas modernistas que se esconden en el barcelonés distrito del Eixample, ubicado en el centro de la ciudad. visitaremos los edificios más célebres del arquitecto Gaudí.","Ciudad, a pie, excursión larga.","https://i.ibb.co/qWngCW2/modernismo-F.png"),

        new Experience(4l,"Del huerto a la mesa", 145, 3,"Actividad disponible para todas las edades","Comparte con los más pequeños las maravillas de la naturaleza. En esta excursión breve de tres horas, podréis plantar vuestras propias hortalizas y verduras en el huerto de Can Gilabert, ubicado en el corazón del Montbaig. .","Montaña, a pie,excursión corta","https://i.ibb.co/9tCsvR9/HuertoF.png"),


                new Experience(5l,"Arte en la montaña sagrada", 125, 2,"Actividad disponible para todas las edades","Disfruta de la impresionante Montaña de Montserrat donde encontraréis el Museo con las salas modernistas de Puig i Cadafalch, lugar que acoge colecciones de gran valor en el corazón de la emblemática montaña. En el Museo .","Montaña, a pie, excursión corta.","https://i.ibb.co/FV7z1wR/Montserrat-F.png")));




    }
}