package kg.Kursanov.interfase.impl;

import kg.Kursanov.db.DataBase;

import kg.Kursanov.interfase.MovieSortService;
import kg.Kursanov.models.Movie;

import java.util.Collections;
import java.util.Comparator;

public class MovieSortServiceImpl implements MovieSortService {
    @Override
    public void sortMovieByName(String ascOrDesc) {
        Comparator<Movie> nameComparator = Comparator.comparing(Movie::getName);

        try {


            if (ascOrDesc.equalsIgnoreCase("desc")) {
                Collections.sort(DataBase.movies, nameComparator.reversed());
            } else if (ascOrDesc.equalsIgnoreCase("asc")) {
                Collections.sort(DataBase.movies, nameComparator);

            }
            for (Movie movie : DataBase.movies) {
                System.out.println(movie);

            }
        }catch (Exception e){
            System.out.println("Сортто ошибка чыкты" + e.getMessage());

        }

    }

    @Override
    public void sortByYear(String ascOrDes) {

        Comparator<Movie> yearComparator = Comparator.comparing(Movie::getYear);
        try {
            if (ascOrDes.equalsIgnoreCase("desc")) {
                Collections.sort(DataBase.movies, yearComparator.reversed());
            } else if (ascOrDes.equalsIgnoreCase("asc")) {
                Collections.sort(DataBase.movies, yearComparator);
            }
            for (Movie movie : DataBase.movies) {
                System.out.println(movie);
            }
        }catch (Exception e) {
            System.out.println("Сортто ошибка чыкты" + e.getMessage());
        }


    }

    @Override
    public void sortByProducer(String nameOrLastName,String ascOrDes) {


        Comparator<Movie> nameProducer;
        if ("firstName".equalsIgnoreCase(nameOrLastName)) {
            nameProducer = Comparator.comparing(movie -> movie.getProducer().getFirstName());
        } else if ("lastName".equalsIgnoreCase(nameOrLastName)) {
            nameProducer = Comparator.comparing(movie -> movie.getProducer().getLastName());
        }else {
            nameProducer = Comparator.comparing(movie -> movie.getProducer().getFirstName());
        }
        try {
            if (ascOrDes.equalsIgnoreCase("desc")) {
                nameProducer = nameProducer.reversed();
            } else if (ascOrDes.equalsIgnoreCase("asc")) {
                Collections.sort(DataBase.movies, nameProducer);

            }

            Collections.sort(DataBase.movies, nameProducer.reversed());
            for (Movie movie : DataBase.movies) {
                System.out.println(movie);

            }
        }catch (Exception e){
            System.out.println("Сортто ошибка чыкты" + e.getMessage());
        }


    }


}
