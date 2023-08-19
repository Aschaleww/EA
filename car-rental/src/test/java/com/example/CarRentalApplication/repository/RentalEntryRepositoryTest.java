package com.example.CarRentalApplication.repository;

import com.example.CarRentalApplication.domain.RentalEntry;
import com.example.CarRentalApplication.domain.RentalStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RentalEntryRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RentalEntryRepository rentalEntryRepository;

    @Test
    public void canFindByLicensePlate() {
        // given
        RentalEntry rentalEntry = new RentalEntry("12-3456", LocalDate.now(), LocalDate.now(), RentalStatus.AVAILABLE);
        entityManager.persist(rentalEntry);
        entityManager.flush();

        // when
        List<RentalEntry> actual = rentalEntryRepository.findByLicensePlate("12-3456");

        // then
        assertThat(actual.size(), equalTo(1));
        assertThat(actual.get(0).getLicensePlate(), equalTo("12-3456"));
    }
}
