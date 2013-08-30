package com.fernandogodoy.exemploboot.post;

import com.fernandogodoy.exemploboot.get.MyHttpGetImp;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando Godoy
 */
public class Exemplo {

    public static final String URL_ACCOUNTS = "https://accounts.google.com/ServiceLogin?hl=pt-BR&continue=https://www.google.com.br/";
    public static final String EXPRESSAO_FORM_LOGIN = "<form .*? id=\"gaia_loginform\" .*?>.*?</form>";

    public static void main(String[] args) throws IOException {
        String formulario = getFormLoginGoogle();
    }

    /**
     * Executa um HTTP GET em uma URL do Google Accounts
     *
     * @return HTML do formulário de Login
     * @throws IOException
     */
    private static String getFormLoginGoogle() throws IOException {
        MyHttpGetImp http = new MyHttpGetImp();
        Matcher matcher = Pattern.compile(EXPRESSAO_FORM_LOGIN, Pattern.DOTALL).matcher(http.get(URL_ACCOUNTS));
        if (matcher.find()) {
            System.out.println(matcher.group());
            return matcher.group();
        }
        return null;
    }

    private static Map extractPostParameters(String htmlFormLogin) {

        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"hidden\" .*? id=\"continue\" value=\"(.*?)\"? >");
        return null;
    }
}
