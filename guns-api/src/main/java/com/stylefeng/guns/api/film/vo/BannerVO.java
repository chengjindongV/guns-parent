package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: chengjindong
 * @Date: 2019/9/24 21:37
 */
@Data
public class BannerVO implements Serializable {

    private String bannerId;

    private String bannerAddress;

    private String bannerUrl;

}
