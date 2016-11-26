package com.idt.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * User template for immutables, using this template immutable will take care of the boiler plate code (getters, setters) also immutable will override to string e hashcode
 * also User will be immutable.
 *
 * Created by eric.nascimento on 2/18/16.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableUser.class)
@JsonDeserialize(as = ImmutableUser.class)
public interface User {

    UUID id();

    String name();

    String surName();

    String email();

    String phoneNumber();

    Optional<Instant> modifiedDate();

}