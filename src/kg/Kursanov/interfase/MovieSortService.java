package kg.Kursanov.interfase;

import java.time.LocalDate;

public interface MovieSortService {

    void sortMovieByName(String ascOrDesc);

    void sortByYear(String ascOrDes);

    void sortByProducer(String nameOrLastName,String ascOrDes);

}
