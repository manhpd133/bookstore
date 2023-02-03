package com.example.booksellstore.GoogleSheetApi;

import com.example.booksellstore.model.Product;
import com.example.booksellstore.reponsitory.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
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
        List<List<Object>> valueRanges = getDataFromGoogleSheetProduct("bookStore");
        convertGoogleSheetDataToProduct(valueRanges);
        log.info("Render test data to database successfully!");
    }
    public List<List<Object>> getDataFromGoogleSheetProduct(String sheetName) throws IOException, GeneralSecurityException {
        String SPREADSHEET_ID = "1Po8QePukB6nZAPiSdz1Udivj9SwqxlWXulFTHcVI9-4";
        return sheetDataService.getSheetsServiceProduct(SPREADSHEET_ID);
    }

    public void convertGoogleSheetDataToProduct(@NotNull List<List<Object>> rows) {
        log.info("=======> syncing data: " + rows.size());

        for(List<Object> row : rows) {
            String id_product = (String) row.get(0);
            String name_product = (String) row.get(1);
            String price = (String) row.get(2);
            String detail = (String) row.get(3);
            String quantity = (String) row.get(4);
            String create_date = (String) row.get(5);
            String image = (String) row.get(6);
            String author = (String) row.get(7);
            String supplier = (String) row.get(8);
            String id_cate = (String)  row.get(9);
            String id_product_cate = (String) row.get(10);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date;
            try {
              date =  simpleDateFormat.parse(create_date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            log.info(rows);
            Product product = new Product(Long.parseLong(id_product),name_product,Float.parseFloat(price),detail,Integer.parseInt(quantity),date ,image,author,supplier,Long.parseLong(id_cate),
                                    Long.parseLong(id_product_cate));
            productRepo.save(product);
        }

    }

}
