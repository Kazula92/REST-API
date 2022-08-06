package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTest {

    TrelloMapper trelloMapper= new TrelloMapper();

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = List.of(
                new TrelloBoardDto("id", "name",
                        List.of(new TrelloListDo("id", "name", true))));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        TrelloBoard trelloBoard = trelloBoards.get(0);
        TrelloBoardDto trelloBoardDto = trelloBoardDtos.get(0);

        assertEquals(trelloBoard.getId(), trelloBoardDto.getId());
        assertEquals(trelloBoard.getName(), trelloBoardDto.getName());

        TrelloList trelloList = trelloBoard.getLists().get(0);
        TrelloListDo trelloListDto = trelloBoardDto.getLists().get(0);

        assertEquals(trelloList.getId(), trelloListDto.getId());
        assertEquals(trelloList.getName(), trelloListDto.getName());
        assertEquals(trelloList.isClosed(), trelloListDto.isClosed());

    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = List.of(
                new TrelloBoard("id", "name",
                        List.of(new TrelloList("id", "name", true))));

        //When
        List<TrelloBoardDto> trelloBoardDto1 = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        TrelloBoard trelloBoard = trelloBoards.get(0);
        TrelloBoardDto trelloBoardDto = trelloBoardDto1.get(0);

        assertEquals(trelloBoard.getId(), trelloBoardDto.getId());
        assertEquals(trelloBoard.getName(), trelloBoardDto.getName());

        TrelloList trelloList = trelloBoard.getLists().get(0);
        TrelloListDo trelloListDto = trelloBoardDto.getLists().get(0);

        assertEquals(trelloList.getId(), trelloListDto.getId());
        assertEquals(trelloList.getName(), trelloListDto.getName());
        assertEquals(trelloList.isClosed(), trelloListDto.isClosed());
    }

    @Test
    public void shouldMapToCardDto() {
        // given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        // when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        // then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void shouldMapToCard() {
        // given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");

        // when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        // then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }
}
