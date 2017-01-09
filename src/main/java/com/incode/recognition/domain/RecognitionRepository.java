package com.incode.recognition.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecognitionRepository extends CrudRepository<Recognition, Long> {

}
