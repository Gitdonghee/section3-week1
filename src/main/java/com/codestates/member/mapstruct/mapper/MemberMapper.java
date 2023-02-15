package com.codestates.member.mapstruct.mapper;

import com.codestates.member.MemberPatchDto;
import com.codestates.member.MemberPostDto;
import com.codestates.member.MemberResponseDto;
import com.codestates.member.Member;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
