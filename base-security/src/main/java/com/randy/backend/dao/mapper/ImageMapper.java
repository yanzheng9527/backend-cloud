package com.randy.backend.dao.mapper;

import com.randy.backend.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMapper {
  void insert(Image image);
  Image getOneById(int id);
}
