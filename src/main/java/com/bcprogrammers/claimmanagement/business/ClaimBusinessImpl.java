package com.bcprogrammers.claimmanagement.business;

import com.bcprogrammers.claimmanagement.model.entities.Claim;
import com.bcprogrammers.claimmanagement.model.entities.Status;
import com.bcprogrammers.claimmanagement.model.entities.User;
import com.bcprogrammers.claimmanagement.model.expose.ClaimRs;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import com.bcprogrammers.claimmanagement.model.type.StatusType;
import com.bcprogrammers.claimmanagement.repository.ClaimRepositoryJpa;
import com.bcprogrammers.claimmanagement.repository.UserRepositoryJpa;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        if (byDocument.isPresent()) {
            Claim claim = claimRepositoryJpa.save(mapRqToEntity.apply(request,
                    byDocument.get()));
            return Maybe.just(mapClaimEntityToRs.apply(claim));
        } else {
            User save = userRepositoryJpa.save(mapRqToUserEntity.apply(request));
            return Maybe.just(mapEntityToRs.apply(save));
        }
    }

    @Override
    public Observable<ClaimRs> list(Integer documentType, String documentNumber) {
        return Observable.fromIterable(claimRepositoryJpa.findClaimsByUser(documentType, documentNumber)
                .stream().map(claim -> ClaimRs.builder().build())
                .collect(Collectors.toList()));
    }

    private final Function<User, ClaimSaveRs> mapEntityToRs =
            (user) -> ClaimSaveRs.builder()
                    .code(user.getItems().get(0).getClaimId())
                    .description(user.getItems().get(0).getDescription())
                    .build();

    private final Function<Claim, ClaimSaveRs> mapClaimEntityToRs =
            (claim) -> ClaimSaveRs.builder()
                    .code(claim.getClaimId())
                    .description(claim.getDescription())
                    .build();

    private final BiFunction<ClaimSaveRq, User, Claim> mapRqToEntity =
            (rq, user) -> Claim.builder()
                    .user(user)
                    .description(rq.getDescription())
                    .claimType(rq.getClaimType())
                    .createDate(LocalDateTime.now())
                    .status(Collections.singletonList(Status.builder()
                            .statusId(Long.valueOf(StatusType.STARTED.getCode()))
                            .lastUpdatedDate(LocalDateTime.now())
                            .build()))
                    .build();

    private final Function<ClaimSaveRq, User> mapRqToUserEntity =
            (rq) -> User.builder()
                    .documentNumber(rq.getUser().getDocumentNumber())
                    .documentType(rq.getUser().getDocumentType())
                    .phoneNumber(rq.getUser().getPhoneNumber())
                    .emailAddress(rq.getUser().getEmailAddress())
                    .items(Collections.singletonList(Claim.builder()
                            .description(rq.getDescription())
                            .claimType(rq.getClaimType())
                            .createDate(LocalDateTime.now())
                            .status(Collections.singletonList(Status.builder()
                                    .statusId(Long.valueOf(StatusType.STARTED.getCode()))
                                    .lastUpdatedDate(LocalDateTime.now())
                                    .build()))
                            .build()))
                    .build();
}
