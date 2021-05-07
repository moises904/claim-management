package com.bcprogrammers.claimmanagement.business;

import com.bcprogrammers.claimmanagement.model.entities.Claim;
import com.bcprogrammers.claimmanagement.model.entities.User;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import com.bcprogrammers.claimmanagement.repository.ClaimRepositoryJpa;
import com.bcprogrammers.claimmanagement.repository.UserRepositoryJpa;
import io.reactivex.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.BiFunction;

@Service
@AllArgsConstructor
public class ClaimBusinessImpl implements ClaimBusiness {

    private final ClaimRepositoryJpa claimRepositoryJpa;
    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public Maybe<ClaimSaveRs> saveClaim(ClaimSaveRq request) {
        Optional<User> byDocument = userRepositoryJpa
                .findByDocumentTypeAndDocumentNumber(request.getUser().getDocumentType(),
                        request.getUser().getDocumentNumber());
        return Maybe.empty();

    }

    private final BiFunction<ClaimSaveRq, User, Claim> mapRqToEntity =
            (rq, user) -> Claim.builder()
                    .user(user)
                    .description(rq.getDescription())
                    .claimType(rq.getClaimType())
                    .createDate(LocalDateTime.now())
                    .build();
}
