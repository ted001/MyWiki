package com.ted.mywiki.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ted.mywiki.domain.Ebook;
import com.ted.mywiki.domain.EbookExample;
import com.ted.mywiki.mapper.EbookMapper;
import com.ted.mywiki.req.EbookReq;
import com.ted.mywiki.resp.EbookResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;


    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            respList.add(ebookResp);
        }
        return respList;

    }
    public void delete(Long id) {
        ebookMapper.deleteByPrimaryKey(id);
    }
}
