package com.ted.mywiki.controller;

import com.ted.mywiki.req.EbookQueryReq;
import com.ted.mywiki.req.EbookSaveReq;
import com.ted.mywiki.resp.CommonResp;
import com.ted.mywiki.resp.EbookQueryResp;
import com.ted.mywiki.resp.PageResp;
import com.ted.mywiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }
}