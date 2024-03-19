import kg.Kursanov.db.DataBase;
import kg.Kursanov.emums.Genre;
import kg.Kursanov.interfase.impl.MovieServiceImpl;
import kg.Kursanov.interfase.MovieSortService;
import kg.Kursanov.interfase.impl.MovieSortServiceImpl;
import kg.Kursanov.models.Actor;
import kg.Kursanov.models.Movie;
import kg.Kursanov.models.Producer;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        MovieServiceImpl movieService = new MovieServiceImpl();
        MovieSortService movieServiceImpl = new MovieSortServiceImpl();

        Producer producerFromPT = new Producer("Don" ,"Carmodi");
        Producer producerFromT = new Producer("James" ,"Cameron");
        Producer producer = new Producer("Aza","Ruzbaev");


        Actor emilEsenaliev =  new Actor("Emil Esenaliev","bala");
        Actor bolotTentimishov =  new Actor("Bolot Tentimishov","post");
        Actor emilToktoshev =  new Actor("Emil Toktoshev","kuiobala");
        Actor kateWinslet =  new Actor("Kate Winslet","kyz");
        Actor leonardoDiCaprio =  new Actor("Leonardo DiCaprio","bala");
        Actor desmonHarington =  new Actor("Desmon Harington","vampir");
        Actor lindiBut =  new Actor("Lindi Butt","vampir");
        Actor kevinZegrs =  new Actor("Kevin Zegrs","vampir");

        List<Actor> actorsFromBETA = new ArrayList<>(List.of(emilEsenaliev,bolotTentimishov,emilToktoshev));
        List<Actor> actorsFromTitanic = new ArrayList<>(List.of(kateWinslet,leonardoDiCaprio));
        List<Actor> actorsFromPT= new ArrayList<>(List.of(desmonHarington,lindiBut,kevinZegrs));

        Movie movieBETA = new Movie("Beish enenin tamanynda", LocalDate.of(2024,2,8), Genre.DRAMMA,producer,actorsFromBETA);
        Movie movieTitanic= new Movie("Titanic", LocalDate.of(1997,2,9), Genre.FANTASTIKA,producerFromT,actorsFromTitanic);
        Movie moviePT= new Movie("Поворот не туда", LocalDate.of(2000,2,12), Genre.UJASS,producerFromPT,actorsFromPT);
        List<Movie> movies = new ArrayList<>(List.of(movieBETA,movieTitanic,moviePT));
        DataBase.movies.addAll(movies);
        DataBase.actors.addAll(actorsFromPT);
        DataBase.actors.addAll(actorsFromTitanic);
        DataBase.actors.addAll(actorsFromBETA);



        while (true){
            System.out.println("""
                    1.Get all movies
                    2.Find Movie By Full Name Or Part Name
                    3.Find Movie By Actor Name
                    4.Find Movie By Year
                    5.Find Movie By Producer Name
                    6.Find Movie By Genre
                    7.Find Movie By Role
                    8.Sort Movie By name
                    9.Sort Movie By year
                    10.Sort Movie By Producer name (desc)
                    """);
            switch (new Scanner(System.in).nextInt()){
                case 1 ->{
                    movieService.getAllMovies();break;

                }
                case 2 ->{
                    System.out.println("Write name movie: ");
                    movieService.findMovieByFullNameOrPartName(new Scanner(System.in).nextLine());
                    break;
                }
                case 3 ->{
                    System.out.println("Write actor name: ");
                    movieService.findMovieByActorName(new Scanner(System.in).nextLine());break;
                }
                case 4->{
                    movieService.findMovieByYear(LocalDate.of(2024,2,8));
                }
                case  5->{
                    movieService.findMovieByProducer("Nurmuhamed");
                }
                case 6->{
                    movieService.findMovieByGenre(Genre.UJASS);
                }
                case 7->{
                    movieService.findMovieByRole("vampir");
                }
                case 8->{
                    movieServiceImpl.sortMovieByName("desc");
                }
                case 9->{
                    movieServiceImpl.sortByYear("asc");
                }
                case 10 ->{
                    movieServiceImpl.sortByProducer("lastName","desc");
                }

            }
            }
        }



    }
