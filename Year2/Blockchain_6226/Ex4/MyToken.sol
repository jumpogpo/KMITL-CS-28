// SPDX-License-Identifier: MIT
pragma solidity ^0.8.1;
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/token/ERC20/ERC20.sol";
contract Mytoken is ERC20 {
    uint8 private dec;
    constructor(string memory _name, string memory _symbol, uint8 _dec, 
         uint256 _initialSupply) ERC20(_name, _symbol)  {
         dec = _dec;    
        _mint(msg.sender, _initialSupply);
    }
    function decimals() public view virtual override returns (uint8) {
        return dec;
    }
}
