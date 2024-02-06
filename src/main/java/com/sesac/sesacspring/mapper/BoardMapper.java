package com.sesac.sesacspring.mapper;

import com.sesac.sesacspring.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface BoardMapper {
    // sql을 작성하거나, xml 파일을 작성하거나
    // 1)mapper에는 메소드가 있고, xml에는 없느 경우 -> 실행할 때 오류
    // 2)xml에는 있고, mapper에는 없는 경우 -> 실행 자체가 안됨
    List<Board> selectAll(); //전체 조회

    @Insert("insert into board(id, title, writer, date) values(#{id}, #{title}, #{writer}, sysdate)")
    void createBoard(int id, String title, String writer);

    @Update("update board set ")
    void updateBoard(Board board);

}
