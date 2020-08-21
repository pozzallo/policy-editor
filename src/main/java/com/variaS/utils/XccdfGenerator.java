package com.variaS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Element;
import org.jdom.JDOMException;

import com.g2inc.scap.library.domain.SCAPDocument;
import com.g2inc.scap.library.domain.SCAPDocumentFactory;
import com.g2inc.scap.library.domain.UnsupportedDocumentTypeException;
import com.g2inc.scap.library.domain.xccdf.Check;
import com.g2inc.scap.library.domain.xccdf.Profile;
import com.g2inc.scap.library.domain.xccdf.Rule;
import com.g2inc.scap.library.domain.xccdf.impl.XCCDF114.XCCDFBenchmark;
import com.variaS.entity.Policy;


public class XccdfGenerator {

	private static final Logger log = Logger.getLogger(XccdfGenerator.class);

	public static Policy createPolicy(InputStream inputStreamPolicy) {
		Policy policy = null;
		try {
			SCAPDocument sdoc = SCAPDocumentFactory.loadDocument(inputStreamPolicy);
			if (sdoc != null) {
				if (sdoc instanceof XCCDFBenchmark) {
					XCCDFBenchmark benchmark = (XCCDFBenchmark) sdoc;
					policy = new Policy();
					policy.setDescription(benchmark.getDescriptionAsString());
					policy.setTitle(benchmark.getTitle());
					policy.setVersion(Integer.valueOf(benchmark.getVersion().getVersion()));

					List<Profile> profileList = benchmark.getProfileList();
					List<com.variaS.entity.Profile> profiles = new ArrayList<>();
					for (Profile profile : profileList) {
						com.variaS.entity.Profile profileEntity = new com.variaS.entity.Profile();
						profileEntity.setDescription(profile.getTitle());
						profileEntity.setTitle(profile.getId());
						profileEntity.setPolicy(policy);
						profiles.add(profileEntity);
					}
					policy.setProfiles(profiles);

					List<Rule> allRules = benchmark.getAllRules();
					List<com.variaS.entity.Rule> rules = new ArrayList<>();
					for (Rule rule : allRules) {
						com.variaS.entity.Rule entityRule = new com.variaS.entity.Rule();

						entityRule.setFixText(rule.getFixTextList().get(0).getText());
						entityRule.setTitle(rule.getId());
						entityRule.setPolicy(policy);
						entityRule.setDescription(rule.getTitle());

						Check check = rule.getCheckList().get(0);
						Element checkContentElement = (Element) check.getElement().getChildren().get(1);
						String checkText = checkContentElement.getText();
						entityRule.setCheckedText(checkText);
						rules.add(entityRule);
					}
					policy.setRules(rules);

				}
			}

		} catch (JDOMException | IOException | UnsupportedDocumentTypeException e) {
			e.printStackTrace();
		}
		return policy;
	}

}
