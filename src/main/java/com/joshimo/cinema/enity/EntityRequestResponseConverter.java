package com.joshimo.cinema.enity;

public interface EntityRequestResponseConverter<Req, E, Resp> {

    E requestToEntity(Req request);

    Resp entityToResponse(E entity);

}
