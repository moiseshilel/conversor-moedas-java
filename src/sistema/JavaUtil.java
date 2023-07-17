package sistema;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtil {
	
    private static final Pattern REGEX = Pattern.compile("\"high\":\"([^\"]+)\"|\"create_date\":\"([^\"]+)\"", Pattern.MULTILINE);

    public String[] Parser(String json) {

    Matcher matcher = REGEX.matcher(json);

        // Função para verificar se o padrão foi encontrado e obter o valor.
        String highValue[] = new String [2];
        for (int i = 0; i < highValue.length; i++) {
            if (matcher.find()) {
                highValue[i] = matcher.group(i+1);
            } else {
                break;
            }
        }
        return highValue;

    }
    
}
