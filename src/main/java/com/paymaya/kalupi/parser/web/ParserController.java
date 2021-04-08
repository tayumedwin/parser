package com.paymaya.kalupi.parser.web;

import com.paymaya.kalupi.parser.core.ParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ParserController {

    private static final Logger LOG = LoggerFactory.getLogger(ParserController.class);

    private final ParserService parserService;

    public ParserController(ParserService parserService){
        LOG.debug("ParserController");
        this.parserService = parserService;
    }

    @GetMapping("/parser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity parseState(@RequestParam("logdate") String logdate, @RequestParam("logname") String logname, @RequestParam("logtype") String logtype){
        LOG.info("parseState|"+logdate+"|"+logname+"|"+logtype);
        if(containsIgnoreCase(logname, "commit")){
            parserService.parseMochiCommit(logdate, logname, logtype);
        }else if(containsIgnoreCase(logname, "state")){
            parserService.parseMochiState(logdate,logname, logtype);
        }else{
            parserService.parseMochiLedger(logdate, logname, logtype);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
}
