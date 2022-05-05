package com.study.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.blog.config.auth.PrincipalDetail;
import com.study.blog.model.Board;
import com.study.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"", "/"})
	public String index(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		int pageSize = 5;
		int startPage = (pageable.getPageNumber() / pageSize) * pageSize + 1;
        int endPage = startPage + pageSize - 1;
        model.addAttribute("startPageNo", startPage);
        model.addAttribute("endPageNo", endPage);
		model.addAttribute("boards", boardService.글목록(pageable));
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/detail";
	}
	
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model, @AuthenticationPrincipal PrincipalDetail principal, HttpServletResponse response) throws IOException {
		Board board = boardService.글상세보기(id);
		if(board.getUser().getId() != principal.getUser().getId()) {
			return "redirect:/";
		}
		model.addAttribute("board", board);
		return "board/updateForm";
	}

}
