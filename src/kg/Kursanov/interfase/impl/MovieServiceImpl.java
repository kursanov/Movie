package kg.Kursanov.interfase.impl;

import kg.Kursanov.db.DataBase;
import kg.Kursanov.emums.Genre;
import kg.Kursanov.interfase.MovieService;
import kg.Kursanov.models.Actor;
import kg.Kursanov.models.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getAllMovies() {

        try {
            System.out.println(DataBase.movies);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return DataBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        Movie movieNew = null;
        for (Movie movie : DataBase.movies) {
            try {
                if (movie.getName().contains(name) || movie.getName().equalsIgnoreCase(name)){
                    movieNew = movie;
                    System.out.println(movie);break;

                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        return movieNew;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        try {
            for (int i = 0; i < DataBase.movies.size(); i++) {
                for (int i1 = 0; i1 < DataBase.movies.get(i).getActors().size(); i1++) {
                    if (actorName.equalsIgnoreCase(DataBase.movies.get(i).getActors().get(i1).getActorFullName())) {
                        System.out.println(DataBase.movies.get(i));
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Издоодо ошибка чыкты  " + e.getMessage());
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        try {
            for (Movie movie : DataBase.movies) {
                if (movie.getYear().isEqual(year)) {
                    System.out.println(movie);
                    break;
                }
            }
        }catch (Exception e){
            System.err.println("Oшибка findMovieByYear");
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        try {


            for (Movie movie : DataBase.movies) {
                if (movie.getProducer().getFirstName().equalsIgnoreCase(producerFullName)) {
                    System.out.println(movie);
                    break;
                }

            }
        }catch (Exception e){
            System.out.println("Издоодо ошибка чыкты " + e.getMessage());
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        try {


            for (Movie movie : DataBase.movies) {
                if (movie.getGenre().equals(genre)) {
                    System.out.println(movie);
                    break;
                }

            }
        }catch (Exception e){
            System.out.println("Издоодо ошибка чыкты " + e.getMessage());
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        try {
            for (int i = 0; i < DataBase.movies.size(); i++) {
                for (int i1 = 0; i1 < DataBase.movies.get(i).getActors().size(); i1++) {
                    if (role.equalsIgnoreCase(DataBase.movies.get(i).getActors().get(i1).getRole())) {
                        System.out.println(DataBase.movies.get(i));
                        break;
                    }

                }


            }
        }catch (Exception e){
            System.out.println("Издоодо ошибка чыкты " + e.getMessage());
        }
        return null;
    }
}
