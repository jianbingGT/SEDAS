package com.sedationassist.service;

import com.sedationassist.model.SedationOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// input is the score
// a method to return a list of options
@Service
public class CalculateOption {
    public CalculateOption() {

    }

    @Override
    public String toString() {
        return "CalculateOption{}";
    }

    public List<SedationOption> calculatedoption(int scopescore){
        List<SedationOption> options1  =  new ArrayList<SedationOption>();
        options1.add(new SedationOption("Fentnyl", "25 mcg IV",  30));
        options1.add(new SedationOption("Midazolam", "0.5 mcg IV",  30));
        options1.add(new SedationOption("Naloxone", "0.1 mg IV ",  40));

        List<SedationOption> options2  =  new ArrayList<SedationOption>();
        options2.add(new SedationOption("Fentnyl", "35 mcg IV",  50));
        options2.add(new SedationOption("Midazolam", "10. mcg IV",  40));
        options2.add(new SedationOption("Naloxone", "0.1 mg IV ",  50));

        List<SedationOption> options3  =  new ArrayList<SedationOption>();
        options3.add(new SedationOption("Fentnyl", "45 mcg IV",  60));
        options3.add(new SedationOption("Midazolam", "2 mcg IV",  40));
        options3.add(new SedationOption("Naloxone", "0.2 mg IV ",  60));
        if (scopescore > 3){
            return options1;
        }
        else if (scopescore > 2){
            return options3;
        }
        else {
            return options2;
        }
        //return options1;
    }
}
