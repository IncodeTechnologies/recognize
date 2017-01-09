package com.incode.recognition.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class AmazonS3Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${s3.bucket.name}")
	private String bucketName;

	private AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());

	public List<String> getUserImageLinks(String facebookId) {

		List<String> urls = new ArrayList<>();
		try {
			final ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucketName)
					.withPrefix(facebookId).withMaxKeys(100);
			ListObjectsV2Result result;
			do {
				result = s3client.listObjectsV2(req);

				for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
					urls.add(s3client.getUrl(bucketName, objectSummary.getKey()).toString());
				}
				req.setContinuationToken(result.getNextContinuationToken());
			} while (result.isTruncated() == true);

		} catch (Exception e) {
			logger.error("Exception when working with s3", e);
		}
		return urls;
	}

}
