package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;

import java.util.List;

/**
 * @Author: chengjindong
 * @Date: 2019/9/24 22:22
 */
public interface FilmServiceApi {

    // 获取banner信息
    List<BannerVO> getBanners();

    // 获取正在热映的电影
    FilmVO getHotFilms(boolean isLimit,int nums);

    // 即将上映的电影[受欢迎程度做排序]
    FilmVO getSoonFilms(boolean isLimit,int nums);

    // 票房排行榜
    List<FilmInfo> getBoxRanking();

    // 获取受欢迎的榜单
    List<FilmInfo> getExpectRanking();

    // 获取前一百
    List<FilmInfo> getTop();
}
