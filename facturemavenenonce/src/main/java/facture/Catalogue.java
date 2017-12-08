package facture;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    
    Map<String, Article> mycatalogue = new HashMap();
    
    public void addArticle(Article article) {
         mycatalogue.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
         return(mycatalogue.get(code));
    }
    
}
