package com.Kipfk.Library.registration.token;

import com.Kipfk.Library.appuser.AppUser;
import com.Kipfk.Library.appuser.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    ConfirmationToken findByToken(String token);

    Optional<ConfirmationToken> findByAppUser(AppUser appUser);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " + "SET c.confirmedAt = ?2 " + "WHERE c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);

    @Transactional
    void deleteByAppUser(AppUser appUser);

    List<ConfirmationToken> findAllByCreatedAtIsBeforeAndAppUser_AppUserRole(LocalDateTime localDateTime, AppUserRole userRole);
}