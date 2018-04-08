package com.shirokumacafe.archetype.service;

import com.github.pagehelper.PageHelper;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.Answer;
import com.shirokumacafe.archetype.entity.Question;
import com.shirokumacafe.archetype.repository.AnswerMapper;
import com.shirokumacafe.archetype.repository.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @since 2018/4/8
 */
@Service
@Transactional
public class QuestionAnswerService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    public Page<Question> questionPage(Question question, Page page) {
        com.github.pagehelper.Page pageHelper = PageHelper.startPage(page.getCurrentPage(), page.getLimit());
        List<Question> questionList = questionMapper.selectByParams(question);
        page.setRows(questionList);
        page.setResults(Integer.valueOf(String.valueOf(pageHelper.getTotal())));
        return page;
    }

    public void addQuestion(Question question, List<Answer> answers) {
        questionMapper.insertSelective(question);
        if (!CollectionUtils.isEmpty(answers)) {
            for (int i = 0, len = answers.size(); i < len; i++) {
                Answer answer = answers.get(i);
                answer.setqId(question.getqId());
                answerMapper.insertSelective(answer);
            }
        }
    }

    public void updateQuestion(Question question, List<Answer> answers) {
        questionMapper.updateByPrimaryKeySelective(question);
        if (!CollectionUtils.isEmpty(answers)) {
            for (int i = 0, len = answers.size(); i < len; i++) {
                answerMapper.updateByPrimaryKey(answers.get(i));
            }
        }
    }

    public void deleteQuestion(Integer qId) {
        questionMapper.deleteByPrimaryKey(qId);
        Answer answer = new Answer();
        answer.setqId(qId);
        List<Answer> answers = this.queryAnswer(answer);
        if (!CollectionUtils.isEmpty(answers)) {
            for (int i = 0, len = answers.size(); i < len; i++) {
                answerMapper.deleteByPrimaryKey(answers.get(i).getaId());
            }
        }
    }

    public List<Answer> queryAnswer(Answer answer) {
        return answerMapper.selectByParams(answer);
    }

    public void addAnswer(Answer answer) {
        answerMapper.insertSelective(answer);
    }

    public void updateAnswer(Answer answer) {
        answerMapper.updateByPrimaryKey(answer);
    }

    public void deleteAnswer(Integer aId) {
        answerMapper.deleteByPrimaryKey(aId);
    }

}
