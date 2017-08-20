
package org.launchcode.controllers;

import org.launchcode.models.Blog;
import org.launchcode.models.data.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
/**
 * Created by lynnstrauss on 8/20/17.
 */

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogDao blogDao;

    //    Request path: /blog
    @RequestMapping(value = "")
    public String blog(Model model){
        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute("title", "SCW Football Blog");
        return "blog/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBlogForm(Model model) {
        model.addAttribute("title", "Add Blog");
        model.addAttribute(new Blog());
        return "blog/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBlogForm(@ModelAttribute @Valid Blog newBlog,
                                       Errors errors,
                                       Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Blog");
            return "blog/add";
        }

        blogDao.save(newBlog);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveBlogForm(Model model) {
        model.addAttribute("blogs", blogDao.findAll());
        model.addAttribute("title", "Remove Blog");
        return "blog/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveBlogForm(@RequestParam int[] blogIds) {

        for (int blogId : blogIds) {
            blogDao.delete(blogId);
        }

        return "redirect:";
    }

}
