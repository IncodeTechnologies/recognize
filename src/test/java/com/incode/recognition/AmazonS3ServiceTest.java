package com.incode.recognition;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.incode.recognition.service.AmazonS3Service;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmazonS3ServiceTest {

	@Autowired
	private AmazonS3Service amazonService;

	@Test
	public void testS3Buckets() {
		List<String> urls = amazonService.getUserImageLinks("1010369089066938");
		assertFalse(urls.isEmpty());
	}

}
