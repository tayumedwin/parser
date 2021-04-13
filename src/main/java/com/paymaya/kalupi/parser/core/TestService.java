package com.paymaya.kalupi.parser.core;

import com.paymaya.kalupi.parser.domain.Commits;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class TestService {
    private Commits parseCommits() throws IOException, InterruptedException {
        Commits commits = new Commits();

        ProcessBuilder processBuilder = new ProcessBuilder();
        // Run a shell command

        processBuilder.command("bash", "-c", "cat cat src/main/java/com/paymaya/kalupi/parser/input/20210204_mochi-commits_BadConfirm.csv | grep \"txnId\" | cut -d ' ' -f 1 -f 2 -f 24 -f 11 -f 12 -f 13 -f 14 -f 15 -f 16 -f 17 | sort");

        Process process = processBuilder.start();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {

            System.out.println(line);
        }

        int exitCode = process.waitFor();
        System.out.println("\nExited with error code : " + exitCode);

        return  commits;
    }

    public TestService() throws IOException, InterruptedException {
        parseCommits();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        new TestService();
    }
}
