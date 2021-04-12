package com.shrikar.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shrikar.springboot.dto.CovidApiData;
import com.shrikar.springboot.dto.StateData;
import com.shrikar.springboot.dto.SummaryData;

import java.util.Arrays;


@Service
public class Covid19DataProvider {

	static final String URL = "https://api.rootnet.in/covid19-in/stats/latest";

	@Autowired
	RestTemplate restTemplate;

	public StateData getStateData(String state) {

		CovidApiData covidApiData = restTemplate.getForObject(URL, CovidApiData.class);
		if(covidApiData == null) {
            return new StateData();
		}
		else {
			return Arrays.stream(covidApiData.getData().getRegional())
					.filter(e -> e.getLoc().equalsIgnoreCase(state))
					.findAny()
					.orElse(new StateData());
		}


	}

	public SummaryData getSummaryData() {

		CovidApiData covidApiData = restTemplate.getForObject(URL, CovidApiData.class);

		SummaryData summaryData = covidApiData.getData().getSummary();

		summaryData.setUpdateTime(covidApiData.getLastRefreshed());

		return summaryData;
	}
}