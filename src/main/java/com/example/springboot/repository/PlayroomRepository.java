package com.example.springboot.repository;

import com.example.springboot.playroom.Playroom;

import java.util.List;

public interface PlayroomRepository {

    List<Playroom> getPlayrooms();

    void updatePlayrooms(List<Playroom> playrooms);

    void reload();

}
