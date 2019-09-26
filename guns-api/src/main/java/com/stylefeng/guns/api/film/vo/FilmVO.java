package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: chengjindong
 * @Date: 2019/9/24 21:55
 */
@Data
public class FilmVO implements Serializable {

    private int filmNum;

    private List<FilmInfo> filmInfo;
}
