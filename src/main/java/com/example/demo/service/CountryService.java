package com.example.demo.service;

import com.example.demo.dao.CountryDao;
import com.example.demo.dao.WeatherDao;
import com.example.demo.exception.CountryExistException;
import com.example.demo.exception.CountryNotFountException;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.modal.Country;
import com.example.demo.modal.Weather;
import com.example.demo.request.CountryRequest;
import com.example.demo.vo.CountryVO;
import com.example.demo.vo.FileUploadVO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    @Autowired
    WeatherDao weatherDao;

    public CountryVO createCountry(CountryRequest countryRequest) throws CountryExistException {
        try {
            Country existCountry = countryDao.getCountryByName(countryRequest.getName());
            if (existCountry != null) {
                 throw new CountryExistException(countryRequest.getName());
            }
            Country country= CountryMapper.getCountry(countryRequest);
            Country saveCountry=countryDao.saveCountry(country);
            return CountryMapper.getCountryVO(saveCountry);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public FileUploadVO saveWeather(MultipartFile file,String city) throws CountryNotFountException, IOException {
        try {
            Country countryExist;
            {

                countryExist = countryDao.getCountryByCity(city);
                if (countryExist == null) {
                    throw new CountryNotFountException(city);
                }
            }
            List<Weather> weathers = new ArrayList<>();
            Weather weather=new Weather();
            weather = Weather.builder().country(countryExist).report("rain").build();
            weathers.add(weather);
            HSSFWorkbook wb=new HSSFWorkbook((POIFSFileSystem) file);
            HSSFSheet sheet=wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
            for(Row row: sheet)     //iteration over row using for each loop
            {
                for(Cell cell: row)    //iteration over cell using for each loop
                {
                    switch(formulaEvaluator.evaluateInCell(cell).getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            weather = Weather.builder().country(countryExist).report(cell.getStringCellValue()).build();
                            List<Weather> saveWeatherList=weatherDao.createWeather(weathers);
                            break;
                    }
                }
                System.out.println();
            }

            return FileUploadVO.builder().sucess("sucess").build();

        }
        catch (Exception e)
        {
            throw e;
        }

    }
    public List<CountryVO> getAllCountry(String country,String state,String city)
    {
        try {
            List<String> countryList=new ArrayList<>();
            List<String> stateList=new ArrayList<>();
            List<String> cityList=new ArrayList<>();
            if(country==null||country.isEmpty())
            {

            }
            else
            {
               countryList.add(country);
            }
            if(state==null||state.isEmpty()) {

            }
            else
            {
                stateList.add(state);
            }
            if(city==null||city.isEmpty())
            {

            }
            else
            {
                cityList.add(city);
            }
            List<Country> getAllCountry = countryDao.getAllCountry();
            return CountryMapper.getCountryList(getAllCountry);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
