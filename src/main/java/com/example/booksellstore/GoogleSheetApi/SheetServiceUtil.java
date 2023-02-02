package com.example.booksellstore.GoogleSheetApi;

import com.example.booksellstore.model.Product;
import com.example.booksellstore.reponsitory.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Date;
import java.util.List;

@Log4j2
@Service
public class SheetServiceUtil {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private SheetDataService sheetDataService;

    @Autowired
    private ProductRepo productRepo;

    public void renderVocabFromGoogleSheetToDatabase() throws IOException, GeneralSecurityException {
        log.info("Start to retrieve test data from GoogleSheet");
        List<List<Object>> valueRanges = getDataFromGoogleSheetProduct("BookSell");
        convertGoogleSheetDataToProduct(valueRanges);
        log.info("Render test data to database successfully!");
    }
    public List<List<Object>> getDataFromGoogleSheetProduct(String sheetName) throws IOException, GeneralSecurityException {
        String SPREADSHEET_ID = "1UNkxLdjK4YLbgpcNq2IU3WSbBSNcJZQKFkqIOi9ZkbI";
        return sheetDataService.getSheetsServiceProduct(SPREADSHEET_ID);
    }

    public void convertGoogleSheetDataToProduct(List<List<Object>> rows) {
        log.info("=======> syncing data: " + rows.size());
        for(List<Object> row : rows) {
            String id_product = (String) row.get(0);
            String author = (String) row.get(1);
            String id_cate = (String)  row.get(2);
            String create_date = (String) row.get(3);
            String detail = (String) row.get(4);
            String image = (String) row.get(5);
            String name_product = (String) row.get(6);
            String price = (String) row.get(7);
            String id_product_cate = (String) row.get(8);
            String quantity = (String) row.get(9);
            String supplier = (String) row.get(10);

            Product product = new Product(Long.parseLong(id_product),name_product,Float.parseFloat(price),detail,Integer.parseInt(quantity), Date.valueOf(create_date),image,author,supplier,Long.parseLong(id_cate),
                                    Long.parseLong(id_product_cate));
            productRepo.save(product);
        }

    }

}
