package com.teste.project.exemplo.boot.expressao.regular;

import com.teste.project.exemplo.boot.expressao.regular.http.Http;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exemplo simples para extração de informações de um pagina HTML utilizando HTTP GET
 *
 * @author Fernando Godoy
 */
public class ExemploGet {

    private static final String URL = "https://fernandogodoy.wordpress.com/";
    private static final String EXPRESSAO_REGULAR = "<a href=\"http://fernandogodoy.wordpress.com/[0-9]+/[0-9]+/[0-9]+/.*?/\" title=\".*?\">(.*?)</a>";

    public static void main(String[] args) throws IOException {
        Http http = new Http();
        extract(http.get(URL));
    }

    /**
     * Extrai as informações do HTML de acordo com a expressão regular
     * @param htmlPage 
     */
    private static void extract(StringBuilder htmlPage) {
        Matcher matcher = Pattern.compile(EXPRESSAO_REGULAR, Pattern.DOTALL).matcher(htmlPage);
        while (matcher.find()) {
            System.out.println(matcher.group(1).replace("&nbsp;", " "));
        }
    }
}
