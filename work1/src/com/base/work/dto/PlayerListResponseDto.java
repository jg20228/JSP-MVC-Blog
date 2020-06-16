package com.base.work.dto;

import lombok.Builder;

import com.base.work.model.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerListResponseDto {
	private int teamId;
	private Player player;
}
