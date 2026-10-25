# <div align="center">Hi there, I'm Nguyễn Ngọc Tuấn (DanhCaTuanNgoc) 👋</div>

<div align="center">

### **Web3 Fullstack Engineer & Protocol Security Researcher**
*Building deterministic on-chain systems, DeFi primitives, and automated node infrastructure.*

[![GitHub followers](https://img.shields.io/github/followers/DanhCaTuanNgoc?label=Followers&style=flat-square&color=24C6DC)](https://github.com/DanhCaTuanNgoc)
[![GitHub Stars](https://img.shields.io/github/stars/DanhCaTuanNgoc?style=flat-square&color=FF6B6B)](https://github.com/DanhCaTuanNgoc)
[![Hackathon Winner](https://img.shields.io/badge/Honors-2x_Hackathon_Winner-FFD700?style=flat-square&logo=trophy&logoColor=black)](#-hackathon-honors--awards)
[![Dual-VM Builder](https://img.shields.io/badge/Ecosystem-EVM_%7C_Substrate_%7C_Somnia_L1-7C3AED?style=flat-square)](#-ecosystems--chains)

<br/>

[🚀 Featured Projects](#-featured-blockchain-projects) • [🏆 Hackathons](#-hackathon-honors--awards) • [🛠️ Tech Stack](#️-core-tech-stack) • [📐 Engineering Philosophy](#-engineering-philosophy) • [📫 Connect](#-connect-with-me)

</div>

---

### 👨‍💻 About Me

I am a **Blockchain & Fullstack Developer** focused on high-performance decentralized finance, node operations tooling, and smart contract security. I specialize in bridging low-level consensus logic (Substrate/WASM, EVM) with robust off-chain execution engines and modern cybernetic interfaces.

- 🏆 **2x Web3 Hackathon Winner**: Proven track record of architecting, deploying, and validating complex Web3 protocols under competitive hackathon conditions with 100% test pass rates and production-grade deployments.
- ⚡ **Deep Protocol & Infrastructure Focus**: Experienced with Dual-VM runtimes (`pallet-revive`), anti-equivocation node protection, CLOB order matching, and automated market making.
- 🛡️ **Zero-Mock & Security-First**: Strong background in defect auditing, smart contract fuzzing, and deterministic mathematical simulations.

---

### 🏆 Hackathon Honors & Awards

```
╔═══════════════════════════════════════════════════════════════════════════════════════════╗
║                                 🏆 2x HACKATHON WINNER                                    ║
║   Demonstrated independent capability to design, build, test, and ship complete Web3      ║
║   architectures within tight competitive timeframes.                                      ║
╚═══════════════════════════════════════════════════════════════════════════════════════════╝
```

- 🥇 **Web3 Hackathon Award — [Track Winner / High Honor]** *(e.g., Somnia L1 / DoraHacks Builder Bounty)*
  - *Core Submission:* Architected & deployed advanced DeFi/Security solutions (such as institutional-grade defect fuzzing harnesses and autonomous execution terminals).
  - *Key Highlights:* Delivered deterministic reproduction testbeds, audited protocol mechanics, and shipped verified smart contracts on testnet/mainnet.
- 🥇 **Web3 Hackathon Award — [Ecosystem / Infrastructure Track]** *(e.g., Portaldot Hacker House / Arc Microgrants)*
  - *Core Submission:* Engineered automated node operations, validator lease registries, and programmable treasury engines.
  - *Key Highlights:* Comprehensive 100% unit/integration test coverage, custom visual control planes, and live dual-VM interactions.

---

### 🚀 Featured Blockchain Projects

#### 1. [DotNexus](https://github.com/DanhCaTuanNgoc/DotNexus) — Visual Control Plane & Automated SecOps for Portaldot V3.0
> **Track:** Node Operations & Tooling (Portaldot Hacker House) • **Status:** Live & Tested (173/173 tests passed)
- Built an autonomous security operations cockpit for Portaldot Network V3.0 combining **Substrate WASM** consensus with **pallet-revive EVM**.
- **Anti-Equivocation Engine:** Implemented atomic monotonic epoch fencing and smart contract lease registries (`SlashGuardLeaseRegistry.sol`) to eliminate double-signing slashing risks.
- **Mathematical Simulation:** Client-side Sequential Phragmén nPoS simulator providing APY optimization and Planck-to-Wei dynamic decimal conversions.
- **Tech:** Solidity, Python (Substrate Interface, Web3.py), React 19, TypeScript, Tailwind CSS, Three.js 3D Mesh.

#### 2. [ForeSight](https://github.com/DanhCaTuanNgoc/ForeSight) — Autonomous Decision & Execution Terminal on Somnia L1
> **Target:** Somnia Shannon Testnet & DreamDEX CLOB • **Status:** Live Web3 DApp (137/137 tests passed)
- High-throughput decision support terminal for binary prediction markets on Somnia L1.
- **Adversarial AI Engine:** Grounded dual-debate reasoning (Gemini Flash vs. Meta LLaMA 3.3) paired with deterministic trajectory feasibility modeling.
- **Batch Sweeper Contract:** Custom `ForeSightBatchSweeper.sol` for one-click settlement redemption, preventing stranded capital across expired prediction pools.
- **Tech:** Solidity, Viem, Somnia Markets SDK, React 19, TypeScript, Vitest.

#### 3. [Lucid Perps / dreamPerps](https://github.com/DanhCaTuanNgoc/dreamPerps) — CLOB Defect Audit & Parameter Fuzzing Suite
> **Bounty Track:** dreamDEX Perps Feedback & Audit (Somnia Testnet)
- Institutional QA harness stress-testing the CLOB perpetuals ecosystem, SDKs, and settlement contracts (`MarginBank`, `LinkedWalletRegistry`).
- Uncovered and verified **15 critical and major protocol defects** with 100% deterministic minimal reproduction scripts (<20 LOC each) and a one-command automated judge simulation harness.

#### 4. [HOUSE (Contributor)](https://github.com/wildanrhmn/house) — Zero-Inventory Dual-Quote Liquidity Desk
> **Target:** Somnia Shannon • **Protocol:** DreamDEX Event Contracts
- Automated market maker terminal allowing users to "be the book" by simultaneously quoting both sides (YES/NO) one tick inside the spread, minting pairs via pool mechanics for risk-free settlement spread capture.

---

### 🛠️ Core Tech Stack

| Category | Technologies & Tools |
| :--- | :--- |
| **Smart Contracts & Consensus** | Solidity, Rust (ink! / Substrate Pallets), EVM (`pallet-revive`), ERC-20, ERC-721, ERC-4337 (Smart Accounts) |
| **Blockchain SDKs & Libs** | Viem, Ethers.js, Web3.py, Substrate Interface, Somnia Markets SDK, CCXT Facades |
| **Web3 Ecosystems** | Ethereum & EVM L2s, Somnia L1, Substrate / Polkadot Multi-chain, Arc Network |
| **Frontend & Visualization** | React 19, Next.js, Vite, TypeScript, Tailwind CSS, Three.js, Lucide Icons, Recharts |
| **Backend & Automation** | Python (FastAPI/Flask), Node.js, WebSockets, DAG Workflow Engines, Cron Daemons |
| **Testing & Security Auditing** | Vitest, PyTest / Unittest, Hardhat, Foundry, Parameter Fuzzing, Chaos & Reentrancy Stress-testing |

---

### 📐 Engineering Philosophy

- **Zero-Mock Principle:** "If it doesn't execute against a live RPC or consensus runtime, it's not finished."
- **Mathematical Invariants:** Protocol safety must be mathematically provable (e.g., atomic lease times, dynamic precision scaling, liquidity spread conditions).
- **High Information Density UI:** Control planes and dashboards designed for precision, responsive feedback loops, and zero cognitive friction.

---

### 📊 GitHub Activity & Stats

<div align="center">

<img src="https://github-readme-stats.vercel.app/api?username=DanhCaTuanNgoc&show_icons=true&theme=tokyonight&hide_border=true&count_private=true" alt="GitHub Stats" />
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=DanhCaTuanNgoc&layout=compact&theme=tokyonight&hide_border=true" alt="Top Languages" />

</div>

---

### 📫 Connect With Me

- 🌐 **GitHub:** [@DanhCaTuanNgoc](https://github.com/DanhCaTuanNgoc)
- 💼 **LinkedIn:** [linkedin.com/in/your-profile](https://linkedin.com) *(Update with your link)*
- 🐦 **X / Twitter:** [@your_handle](https://x.com) *(Update with your link)*
- 💬 **Discord:** `TuanNgoc` *(or your Discord tag)*
- ✉️ **Email:** `127586212+DanhCaTuanNgoc@users.noreply.github.com`

---
<div align="center">
<sub>Designed & built with relentless focus on decentralization, security, and performance.</sub>
</div>
