//SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;

contract Lottery {
    address public manager;
    address[] public players;
    //1 ประกาศตัวแปรชื่อ winner เพื่อเก็บ address ของผู้ได้รางวัล
    address public winner;

    constructor() {
        //2 ให้ manager คือคนที่ deploy contract ขึ้นมา 
        manager = msg.sender;
    }

    function enter() public payable {
        //3 ใช้ require เพื่อตรวจสอบว่าค่าที่ส่งเข้ามามากกว่า 0.01 ether
        require(msg.value > 0.01 ether, "Minimum entry fee is 0.01 ether");
        //4 เก็บ address ของผู้เล่นลงในอะเรย์ของผู้เล่น 
        players.push(msg.sender);
    }

    function random() private view returns (uint) {
        bytes memory val;
        // val = abi.encodePacked(block.prevrandao, block.timestamp, players); //from compiler version 0.8.18
        val = abi.encodePacked(block.difficulty, block.timestamp, players); //from compiler version < 0.8.18
        return uint(keccak256(val));
    }

    function pickWinner() public checkForOnlyManager { //5 ให้ระบว่า function นี้ใช้ modifier checkForOnlyManager 
        require(players.length > 0, "No players in the lottery");
        uint index = random() % players.length;
        winner = players[index];
        payable(winner).transfer(address(this).balance);
        //clear array for next round
        players = new address[](0);
    }

    //6 สร้าง modifier checkForOnlyManager โดบใช้ require เพื่อตรวจสอบว่าคนที่จะเรียกใช้ฟังก์ชันที่ระบุ modifier นี้ต้องเป็น manager 
    modifier checkForOnlyManager() {
        require(msg.sender == manager, "Only the manager can call this function");
        _;
    }

    function getPlayers() public view returns (address[] memory) {
        return players;
    }
}
