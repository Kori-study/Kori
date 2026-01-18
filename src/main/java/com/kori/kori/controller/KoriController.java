package com.kori.kori.controller;

import com.kori.kori.Clock;
import com.kori.kori.Kori;
import javafx.fxml.FXML;

public class KoriController {

    @FXML
    private Clock clock;

    @FXML
    private Kori kori;



    @FXML
    private void initialize() {
        clock.setTimeFormat("hh:mm:ss a");
        kori.start();
    }

    @FXML
    private void cleanup() {
        clock.dispose();
        kori.dispose();
    }


}
