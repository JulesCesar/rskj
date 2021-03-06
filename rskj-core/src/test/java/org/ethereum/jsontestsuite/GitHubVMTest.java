/*
 * This file is part of RskJ
 * Copyright (C) 2017 RSK Labs Ltd.
 * (derived from ethereumJ library, Copyright (c) 2016 <ether.camp>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.ethereum.jsontestsuite;

import org.json.simple.parser.ParseException;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.ethereum.jsontestsuite.JSONReader.getFileNamesForTreeSha;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore
public class GitHubVMTest {

    //SHACOMMIT of tested commit, ethereum/tests.git
    public String shacommit = "f28ac81493281feec0b17290565cf74042893677";

    @Test
    public void runSingle() throws ParseException {
        String json = JSONReader.loadJSONFromCommit("VMTests/vmEnvironmentalInfoTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, "balance0");
    }

    @Test
    public void testArithmeticFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        // TODO: these are excluded due to bad wrapping behavior in ADDMOD/DataWord.add
        String json = JSONReader.loadJSONFromCommit("VMTests/vmArithmeticTest.json", shacommit);
        //String json = JSONReader.getTestBlobForTreeSha(shacommit, "vmArithmeticTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testBitwiseLogicOperationFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmBitwiseLogicOperationTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testBlockInfoFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmBlockInfoTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testEnvironmentalInfoFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmEnvironmentalInfoTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testIOandFlowOperationsFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmIOandFlowOperationsTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore  //FIXME - 60M - need new fast downloader
    @Test
    public void testvmInputLimitsTest1FromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmInputLimits1.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore //FIXME - 50M - need to handle large filesizes
    @Test
    public void testvmInputLimitsTest2FromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmInputLimits2.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore //FIXME - 20M - possibly provide percentage indicator
    @Test
    public void testvmInputLimitsLightTestFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmInputLimitsLight.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testVMLogGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmLogTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testPerformanceFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmPerformanceTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testPushDupSwapFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmPushDupSwapTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testShaFromGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmSha3Test.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore // // FIXME: as soon as possible
    @Test // testing full suite
    public void testvmSystemOperationsTestGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();

        String json = JSONReader.loadJSONFromCommit("VMTests/vmSystemOperationsTest.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testVMGitHub() throws ParseException {
        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSONFromCommit("VMTests/vmtests.json", shacommit);
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Test // testing full suite
    public void testRandomVMGitHub() throws ParseException {

        String shacommit = "c5eafb85390eee59b838a93ae31bc16a5fd4f7b1";
        List<String> fileNames = getFileNamesForTreeSha(shacommit);
        List<String> excludedFiles =
                Collections.singletonList(
                        ""
                );

        for (String fileName : fileNames) {

            if (excludedFiles.contains(fileName)) continue;
            System.out.println("Running: " + fileName);
            String json = JSONReader.loadJSON("VMTests//RandomTests/" + fileName);
            GitHubJSONTestSuite.runGitHubJsonVMTest(json);
        }

    }
}
